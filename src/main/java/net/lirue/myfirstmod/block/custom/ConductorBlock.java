package net.lirue.myfirstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ComparatorBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ComparatorMode;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class ConductorBlock extends DiodeBlock {
    public ConductorBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.FACING, Direction.SOUTH).setValue(BlockStateProperties.POWERED, false));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(BlockStateProperties.FACING, BlockStateProperties.POWERED);
    }
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if(pContext.getPlayer().isCrouching()){
            return this.defaultBlockState().setValue(BlockStateProperties.FACING, pContext.getNearestLookingDirection().getOpposite());
        }else{
            return this.defaultBlockState().setValue(BlockStateProperties.FACING, pContext.getNearestLookingDirection());
        }
    }
    @Override
    public int getSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        if (!pBlockState.getValue(POWERED)) {
            return 0;
        } else {
            return pBlockState.getValue(BlockStateProperties.FACING) == pSide ? this.getOutputSignal(pBlockAccess, pPos, pBlockState) : 0;
        }
    }
    @Override
    protected int getInputSignal(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction direction = pState.getValue(BlockStateProperties.FACING).getOpposite();
        BlockPos blockpos = pPos.relative(direction);
        int i = pLevel.getSignal(blockpos, direction);
        if (i >= 15) {
            return i;
        } else {
            BlockState blockstate = pLevel.getBlockState(blockpos);
            return Math.max(i, blockstate.is(Blocks.REDSTONE_WIRE) ? blockstate.getValue(RedStoneWireBlock.POWER) : 0);
        }
    }
    @Override
    protected int getAlternateSignal(SignalGetter pLevel, BlockPos pPos, BlockState pState) {
        return 0;
    }
    @Override
    protected void updateNeighborsInFront(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction direction = pState.getValue(BlockStateProperties.FACING);
        BlockPos blockpos = pPos.relative(direction);
        if (!ForgeEventFactory.onNeighborNotify(pLevel, pPos, pLevel.getBlockState(pPos), EnumSet.of(direction.getOpposite()), false).isCanceled()) {
            pLevel.neighborChanged(blockpos, this, pPos);
            pLevel.updateNeighborsAtExceptFromFacing(blockpos.relative(direction), this, direction);
        }
    }
    @Override
    public boolean shouldPrioritize(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        Direction direction = (pState.getValue(BlockStateProperties.FACING)).getOpposite();
        BlockState blockstate = pLevel.getBlockState(pPos.relative(direction));
        return isDiode(blockstate) && blockstate.getValue(BlockStateProperties.FACING) != direction;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(0,  0, 0,  16.0, 16.0, 16.0);
    }
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return true;
    }

    @Override
    protected int getOutputSignal(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return this.getInputSignal((Level)pLevel,pPos,pState);
    }

    @Override
    protected int getDelay(BlockState blockState) {
        return 1;
    }

}

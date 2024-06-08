package net.lirue.myfirstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.Nullable;

public class MultiColoredRedStoneLamp extends Block {

    public MultiColoredRedStoneLamp(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.POWER, 0));
    }
    private void getPower(Level pLevel, BlockPos pPos, BlockState pState) {
        if (!pLevel.isClientSide && pLevel.hasNeighborSignal(pPos)) {
            int signalStrength = pLevel.getBestNeighborSignal(pPos);
            if (pState.getValue(BlockStateProperties.POWER) != signalStrength) {
                pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.POWER, signalStrength), Block.UPDATE_ALL);
            }
        }
    }
    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if (!pLevel.isClientSide) {
            if(pLevel.getBestNeighborSignal(pPos) != 0){
                this.getPower(pLevel, pPos, pState);
            }else{
                pLevel.setBlock(pPos,pState.setValue(BlockStateProperties.POWER,0), 2);
            }
        }
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return (this.defaultBlockState().setValue(BlockStateProperties.POWER, pContext.getLevel().getBestNeighborSignal(pContext.getClickedPos())));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.POWER);
    }

}

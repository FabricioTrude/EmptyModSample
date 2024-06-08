package net.lirue.myfirstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoundBlock extends Block {

    private int step_time = 0;

    public SoundBlock(Properties pProperties){
        super (pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel,
           BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()){
            pLevel.playSound(null, pPos, SoundEvents.NOTE_BLOCK_DIDGERIDOO.get(), SoundSource.BLOCKS);
           // pPlayer.sendSystemMessage(Component.literal("Playing Didgeridoo :D"));
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof Player && !pLevel.isClientSide()){
            step_time = (int) (pLevel.getGameTime() % 20);
            if(this.step_time == 0) {
                if(pEntity.isCrouching()) {
                    pLevel.playSound(null, pPos, SoundEvents.NOTE_BLOCK_CHIME.get(), SoundSource.BLOCKS);
                    //((Player)pEntity).sendSystemMessage(Component.literal("Playing Chime :X "));
                    }
                else{
                    pLevel.playSound(null, pPos, SoundEvents.NOTE_BLOCK_BANJO.get(), SoundSource.BLOCKS);
                    //((Player)pEntity).sendSystemMessage(Component.literal("Playing Banjo :) "));
                    }
            }
           // ((Player)pEntity).sendSystemMessage(Component.literal("Tick = " + step_time));
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.myfirstmod.sound_block"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}

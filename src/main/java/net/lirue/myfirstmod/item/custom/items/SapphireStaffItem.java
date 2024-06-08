package net.lirue.myfirstmod.item.custom.items;

import net.lirue.myfirstmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SapphireStaffItem extends Item {
    public SapphireStaffItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
            if(!pLevel.isClientSide()){
                pPlayer.getInventory().items.forEach(itemStack -> {
                    if (itemStack.is(ModItems.SAPPHIRE.get())) {
                        Snowball shoot = new Snowball(pLevel, pPlayer);
                        shoot.setItem(itemStack);
                        shoot.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
                        pLevel.addFreshEntity(shoot);
                        shoot.hurt(shoot.damageSources().thrown(shoot, shoot.getOwner()),3);
                        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
                        itemStack.shrink(1);
                        //doesnt works //itemStack.hurtAndBreak(1,pPlayer, (e) -> {e.broadcastBreakEvent(pUsedHand);});
                        pPlayer.getCooldowns().addCooldown(ModItems.SAPPHIRE_STAFF.get(), 60);
                    }
                });
            }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}

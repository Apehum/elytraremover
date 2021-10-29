package su.plo.elytraremover.mixin;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Наверное не очень хорошая реализация удаления из инвентаря.
// В креативе оно работает криво, но я не думаю, что это вообще
// когда-нибудь пригодится Pepega
@Mixin(Inventory.class)
public class MixinInventory {
    @Inject(method = "add(Lnet/minecraft/world/item/ItemStack;)Z", at = @At("HEAD"), cancellable = true)
    public void add(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.getItem() instanceof ElytraItem) {
            itemStack.setCount(0);
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(method = "add(ILnet/minecraft/world/item/ItemStack;)Z", at = @At("HEAD"), cancellable = true)
    public void add(int i, ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.getItem() instanceof ElytraItem) {
            itemStack.setCount(0);
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(method = "setItem", at = @At("HEAD"), cancellable = true)
    public void setItem(int i, ItemStack itemStack, CallbackInfo ci) {
        if (itemStack.getItem() instanceof ElytraItem) {
            itemStack.setCount(0);
            ci.cancel();
        }
    }
}

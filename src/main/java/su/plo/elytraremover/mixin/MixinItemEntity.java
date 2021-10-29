package su.plo.elytraremover.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class MixinItemEntity {
    // даже если каким-то образом элитры появятся, то
    // это будет удалять любой ITEM_ENTITY элитр
    @Inject(method = "setItem", at = @At("HEAD"))
    public void setItem(ItemStack itemStack, CallbackInfo ci) {
        if (itemStack.getItem() instanceof ElytraItem) {
            itemStack.setCount(0);
        }
    }
}

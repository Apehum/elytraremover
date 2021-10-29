package su.plo.elytraremover.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.EndCityPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(EndCityPieces.EndCityPiece.class)
public abstract class MixinEndCityPieces {
    @Inject(method = "handleDataMarker", at = @At("HEAD"), cancellable = true)
    public void handleDataMarker(String string, BlockPos blockPos, ServerLevelAccessor serverLevelAccessor, Random random, BoundingBox boundingBox, CallbackInfo ci) {
        if (string.startsWith("Elytra")) {
            ci.cancel();
        }
    }
}

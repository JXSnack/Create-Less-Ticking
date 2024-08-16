package net.dadamalda.create.less_ticking.mixin;

import com.simibubi.create.content.logistics.funnel.FunnelBlockEntity;
import net.dadamalda.create.less_ticking.CLTMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FunnelBlockEntity.class, remap = false)
public abstract class FunnelBlockEntityMixin {
    @Unique
    private int create_less_ticking$tickCounter = 0;

    @Inject(
            method = "tick",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    public void tick(CallbackInfo ci) {
        create_less_ticking$tickCounter++;
        if (create_less_ticking$tickCounter % CLTMod.config.getFunnelTickCooldown() != 0) {
            ((FunnelBlockEntityAccessor) this).setExtractionCooldown(((FunnelBlockEntityAccessor) this).getExtractionCooldown()-1);
            ci.cancel();
        }
    }
}

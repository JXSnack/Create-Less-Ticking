package net.dadamalda.create.less_ticking.mixin;

import com.simibubi.create.content.logistics.chute.ChuteBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ChuteBlockEntity.class, remap = false)
public abstract class ChuteBlockEntityMixin {
    @Unique
    private int tickSlowdown = 3;
    
    @Unique
    private int create_less_ticking$tickCounter = 0;

    @Inject(
            method = "tick",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    public void tick(CallbackInfo ci) {
        create_less_ticking$tickCounter++;
        if (create_less_ticking$tickCounter % tickSlowdown != 0) {
            ci.cancel();
        }
    }
}

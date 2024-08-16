package net.dadamalda.create.less_ticking;

import net.snackbag.shit.config.JSONConfiguration;

public class CLTConfig extends JSONConfiguration {
    private final String funnelTickCooldownKey = "funnelTickCooldown";
    private final String chuteTickCooldownKey = "chuteTickCooldown";

    public CLTConfig(String path) {
        super(path);
        save();
    }

    @Override
    public void save() {
        putIfEmpty(funnelTickCooldownKey, 3);
        putIfEmpty(chuteTickCooldownKey, 3);
        super.save();
    }

    public int getFunnelTickCooldown() {
        return getAsInteger(funnelTickCooldownKey);
    }

    public void setFunnelTickCooldown(int cooldown) {
        put(funnelTickCooldownKey, cooldown);
    }

    public int getChuteTickCooldown() {
        return getAsInteger(chuteTickCooldownKey);
    }

    public void setChuteTickCooldown(int cooldown) {
        put(chuteTickCooldownKey, cooldown);
    }
}

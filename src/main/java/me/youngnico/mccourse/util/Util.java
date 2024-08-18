package me.youngnico.mccourse.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Util {
    public static Vec3d getDirection(PlayerEntity player) {
        double rotX = player.getYaw();
        double rotY = player.getPitch();

        double y = -Math.sin(Math.toRadians(rotY));

        double xz = Math.cos(Math.toRadians(rotY));

        double x = -xz * Math.sin(Math.toRadians(rotX));
        double z = xz * Math.cos(Math.toRadians(rotX));

        return new Vec3d(x, y, z);
    }
}

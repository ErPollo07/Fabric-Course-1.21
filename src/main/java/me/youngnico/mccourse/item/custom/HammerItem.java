package me.youngnico.mccourse.item.custom;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends MiningToolItem {
    public HammerItem(ToolMaterial material, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            if (blockHit.getSide() == Direction.UP || blockHit.getSide() == Direction.DOWN) {
                for (int i = -range; i <= range; i++) {
                    for (int j = -range; j <= range; j++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + i, initialBlockPos.getY(), initialBlockPos.getZ() + j));
                    }
                }
            }

            if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for (int i = -range; i <= range; i++) {
                    for (int j = -range; j <= range; j++) {
                        positions.add(new BlockPos(initialBlockPos.getX() + i, initialBlockPos.getY() + j, initialBlockPos.getZ()));
                    }
                }
            }

            if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for (int i = -range; i <= range; i++) {
                    for (int j = -range; j <= range; j++) {
                        positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + j, initialBlockPos.getZ() + i));
                    }
                }
            }
        }

        return positions;
    }
}

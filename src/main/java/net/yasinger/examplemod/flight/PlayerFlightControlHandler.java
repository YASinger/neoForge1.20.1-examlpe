package net.yasinger.examplemod.flight;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "examplemod", value = Dist.CLIENT)
public class PlayerFlightControlHandler {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!player.level().isClientSide) return;
        if (!player.isFallFlying()) return; // 判断是否在鞘翅飞行

        // 这里监听按键（伪代码，需结合实际输入API实现）
        boolean w = isKeyPressed("W");
        boolean s = isKeyPressed("S");
        boolean a = isKeyPressed("A");
        boolean d = isKeyPressed("D");

        if (w) {
            accelerate(player);
        }
        if (s) {
            decelerate(player);
        }
        if (a) {
            rollLeft(player);
        }
        if (d) {
            rollRight(player);
        }
    }

    // 以下方法需实现具体逻辑
    private static void accelerate(Player player) {
        player.sendSystemMessage(Component.literal("你在飞行状态按住了 W 键，正在加速").withStyle(net.minecraft.ChatFormatting.GREEN));
        // 获取当前速度
        Vec3 motion = player.getDeltaMovement();
        // 增加X方向速度（可根据玩家朝向调整）
        double speedBoost = 0.1;
        Vec3 look = player.getLookAngle();
        player.setDeltaMovement(
                motion.x + look.x * speedBoost,
                motion.y + look.y * speedBoost,
                motion.z + look.z * speedBoost
        );

    }
    private static void decelerate(Player player) {
        player.sendSystemMessage(Component.literal("你在飞行状态按住了 S 键，正在减速").withStyle(net.minecraft.ChatFormatting.YELLOW));
    }
    private static void rollLeft(Player player) {
        player.sendSystemMessage(Component.literal("你在飞行状态按住了 A 键，正在左滚转").withStyle(net.minecraft.ChatFormatting.BLUE));
    }
    private static void rollRight(Player player) {
        player.sendSystemMessage(Component.literal("你在飞行状态按住了 D 键，正在右滚转").withStyle(net.minecraft.ChatFormatting.BLUE));
    }

    // 伪代码：实际应使用合适的输入检测API
    private static boolean isKeyPressed(String key) {
        long window = Minecraft.getInstance().getWindow().getWindow();
        int keyCode = -1;
        switch (key.toUpperCase()) {
            case "W": keyCode = GLFW.GLFW_KEY_W; break;
            case "A": keyCode = GLFW.GLFW_KEY_A; break;
            case "S": keyCode = GLFW.GLFW_KEY_S; break;
            case "D": keyCode = GLFW.GLFW_KEY_D; break;
            // 可根据需要添加更多按键
            default: return false;
        }
        return GLFW.glfwGetKey(window, keyCode) == GLFW.GLFW_PRESS;
    }
}


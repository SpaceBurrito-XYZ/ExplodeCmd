/*
    Copyright (c) SpaceBurritoXYZ Ltd., 2013 - 2020

    This file and code contained within it is property of
    SpaceBurritoXYZ Ltd., and may only be used with the explicit
    written permission of SpaceBurritoXYZ Ltd. unless specified
    otherwise in the License.
 */

package xyz.spaceburrito.mc.explodecmd.common.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.DamageSource;

import java.util.ArrayList;
import java.util.List;

public class ExplodeCommand extends CommandBase {

    public static final DamageSource EXPLOSION = new DamageSource("explosion").setDamageAllowedInCreativeMode();

    @Override
    public List getAliases() {
        ArrayList aliases = new ArrayList();
        aliases.add("suicide");
        return aliases;
    }
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException {
        if (params != null && params.length > 0) {
            if (!(sender instanceof EntityPlayer)) {
                sender.sendMessage(new TextComponentString("[ExplodeCmd] This command can only be run by a player!"));
            } else {
                if (params.length == 1) {
                    EntityPlayer player = (EntityPlayer) sender;
                    player.getEntityWorld().createExplosion(null,
                            player.getPositionVector().x,
                            player.getPositionVector().y,
                            player.getPositionVector().z,
                            Float.parseFloat(params[0]), true);
                } else {
                    sender.sendMessage(new TextComponentString("[ExplodeCmd] Expected 1 param: Explosion Strength"));
                    ((EntityPlayer) sender).attackEntityFrom(EXPLOSION, Float.MAX_VALUE);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "xplode";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/explode <power> - Blow yourself up";
    }
}

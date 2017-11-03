package com.kreezcraft.badwithernocookiereloaded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import scala.actors.threadpool.Arrays;

public class ListenCommand extends CommandBase {


	public String getName() {
		return "listen";
	}

	public String getUsage(ICommandSender sender) {
		return "/listen\n - toggles display of the sound event names in the current text stream";
	}

	public List<String> getAliases() {
		return Lists.newArrayList("wtf","whatwasthat");
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			BadWitherNoCookie.player = (EntityPlayer) sender;
		}
		BadWitherNoCookie.whatWasThat = !BadWitherNoCookie.whatWasThat;
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	
	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public String getCommandName() {
		return getName();
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return getUsage(sender);
	}


}

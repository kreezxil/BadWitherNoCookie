package com.kreezcraft.badwithernocookiereloaded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import scala.actors.threadpool.Arrays;

public class ListenCommand implements ICommand {

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "listen";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "toggles display of the sound event names in the current text stream";
	}

	@Override
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
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		
		return Collections.emptyList();
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.textreader.IText;
import com.earth2me.essentials.textreader.KeywordReplacer;
import com.earth2me.essentials.textreader.TextInput;
import com.earth2me.essentials.textreader.TextPager;
import org.bukkit.Server;


public class Commandmotd extends EssentialsCommand
{
	private IText inputCache;
	public Commandmotd()
	{
		super("motd");
	}

	@Override
	public void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception
	{
		if (sender.isPlayer())
		{
			ess.getUser(sender.getPlayer()).setDisplayNick();
		}
		
		if (inputCache == null) {
			final IText input = new TextInput(sender, "motd", true, ess);
			inputCache = input;
		}
		final IText output = new KeywordReplacer(inputCache, sender, ess);
		final TextPager pager = new TextPager(output);
		pager.showPage(args.length > 0 ? args[0] : null, args.length > 1 ? args[1] : null, commandLabel, sender);
	}
}

package com.linmalu.linkedchat;

import com.linmalu.library.api.LinmaluMain;

public class Main extends LinmaluMain
{
	@Override
	public void onEnable()
	{
		super.onEnable();
		new Main_Command(this);
		new Main_Event(this);
	}
}

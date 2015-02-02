package com.gaver.control;

import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.util.Searcher;

public class AliceBotMother {

	private ByteArrayOutputStream gossip;

	public void setUp() {
		gossip = new ByteArrayOutputStream();
	}

	public String gossip() {
		return gossip.toString();
	}

	public AliceBot newInstance() throws Exception {
		// 初始化文件搜索
		Searcher searcher = new Searcher();
		//
		AliceBotParser parser = new AliceBotParser();
		AliceBot bot = parser.parse(new FileInputStream("zh/Bots/context.xml"),
				new FileInputStream("zh/Bots/splitters.xml"), new FileInputStream(
						"zh/Bots/substitutions.xml"), searcher.search(
						"zh/Bots/Alice", ".*\\.aiml"));

		Context context = bot.getContext();
		context.outputStream(gossip);
		return bot;
	}
}

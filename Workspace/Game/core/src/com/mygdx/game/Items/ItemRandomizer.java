package com.mygdx.game.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class ItemRandomizer {
	FileHandle file = Gdx.files.internal("Scripts/minor(Alien)");
	lines = file.readString().split("[\n]");
	output.add(lines[rnd.nextInt(lines.length)]);
}

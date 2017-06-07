package com.pigletrun.dihgg.game.core;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;

public class GLOBAL {
    public static final int SAW_SPACING = 375; // distância lateral entre as serras
    public static final int SAW_COUNT = 5;  // quantidade de serras do jogo
    public static final int SAW_WIDTH = 156;
    public static Rectangle bounds; // pig bounds
	public static Ranking ranking = new Ranking();
	public static Boolean GAME_OVER;
    public static Boolean gamePaused; // para pausar o jogo
    public static Boolean musicPlaying = false;
	public static Music MUSIC = null;
}
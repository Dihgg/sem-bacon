package com.pigletrun.dihgg.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.pigletrun.dihgg.game.components.characters.Pig;
import com.pigletrun.dihgg.game.components.characters.Saw;
import com.pigletrun.dihgg.game.components.ui.Hud;
import com.pigletrun.dihgg.game.core.BaseScreen;
import com.pigletrun.dihgg.game.core.GLOBAL;

import static com.pigletrun.dihgg.game.core.GLOBAL.GAME_OVER;
import static com.pigletrun.dihgg.game.core.GLOBAL.gamePaused;

class GameScreen extends BaseScreen {
	// VARIÁVEIS
	private Hud hud;
	private Pig pig; // Porco
	//private PowerUp clock;

	GameScreen(final Game game) {
		super(game); // chamar construtor pai
		GAME_OVER = false;
		gamePaused = false;

		GLOBAL.ranking.setScore(0); // zerar o score

		pig = new Pig(stage); // criar novo ator do porco

		stage.addListener(new DragListener() {
			@Override
			public void drag(InputEvent event, float x, float y, int pointer) {
				if (getDeltaY() > 0) //Identifica direção do movimento na tela
					pig.move(-6f); // pig.moveDown();
				else if (getDeltaY() < 0)
					pig.move(6f); //  pig.moveUp();
			}
		});

		stage.addActor(pig); // Adicionar o porco ao cenário
		//adiciona serras ao cenário
		for (int i = 1; i <= Saw.SAW_COUNT; i++) {
			stage.addActor(new Saw((i * Saw.SAW_SPACING) + stage.getWidth()));
		}
		hud = new Hud(stage, game);
		//clock = new PowerUp("clock");
		//stage.addActor(clock);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		hud.update();
		if (GAME_OVER) {
			dispose();
			game.setScreen(new EndScreen(game));
		}
	}
}
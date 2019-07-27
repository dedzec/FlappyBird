package com.dedzec.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture[] passaros;
	private Texture fundo;

	// Atributos de configuração
	private int larguraDispositivo;
	private int alturaDispositivo;

	private float variacao = 0;
	private float velocidadeQueda = 0;
	private float posicaoInicialVertical;

	@Override
	public void create () {

		// Manipulação das texturas
		batch = new SpriteBatch();
		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");

		fundo = new Texture("fundo.png");

		larguraDispositivo = Gdx.graphics.getWidth();
		alturaDispositivo = Gdx.graphics.getHeight();
		posicaoInicialVertical = alturaDispositivo / 2;

	}

	@Override
	public void render () {

		variacao += Gdx.graphics.getDeltaTime() * 7;
		velocidadeQueda++;

		if (variacao > 2) variacao = 0;

		if ( Gdx.input.justTouched() ) {
			velocidadeQueda = -15;
		}

		if (posicaoInicialVertical > 0 || velocidadeQueda < 0) {
			posicaoInicialVertical -= velocidadeQueda;
		}

		// Inicia as imagens
		batch.begin();

		batch.draw(fundo, 0,0, larguraDispositivo, alturaDispositivo);
		batch.draw(passaros[ (int) variacao ], 30, posicaoInicialVertical);

		// Finaliza as imagens
		batch.end();

	}

}

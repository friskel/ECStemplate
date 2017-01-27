package com.friskystudios.ecstemplate;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.friskystudios.ecstemplate.system.PlayerSystem;
import com.kotcrab.vis.runtime.scene.Scene;
import com.kotcrab.vis.runtime.scene.SceneLoader;
import com.kotcrab.vis.runtime.scene.VisAssetManager;

public class MainGameClass extends ApplicationAdapter {
	SpriteBatch batch;
	VisAssetManager manager;
	String scenePath;
	Scene scene;

	
	@Override
	public void create () {

		///// start gamescene
		batch = new SpriteBatch();
		manager = new VisAssetManager(batch);
		manager.getLogger().setLevel(Logger.ERROR);
		scenePath = "scene/gamescene.scene";

		SceneLoader.SceneParameter parameter = new SceneLoader.SceneParameter();
		parameter.config.addSystem(PlayerSystem.class);
		scene = manager.loadSceneNow(scenePath, parameter);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		scene.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

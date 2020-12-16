package com.farias64.jogo;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Game implements ApplicationListener
{
    SpriteBatch batch;
    Camera camera;

    private Stage stage;

    @Override public void create()
    {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Player.start();
        GameHud.start(stage);
        Tiles.start();
        Map1.start();

        camera = new Camera();
        camera.configureCamera();

        batch = new SpriteBatch();
    }

    @Override public void render()
    {        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        Map1.drawMap(batch);
        Player.animation(batch);

        batch.end();

        if (Player.velX > 0.2f && Player.position.x + Player.position.getWidth() > camera.position.x)
        {
						camera.translate(Api.sizeGet(Player.velX), 0);
        }
        if (Player.velX < -0.2f && Player.position.x < camera.position.x)
        {
						camera.translate(Api.sizeGet(Player.velX), 0);
        }

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override public void dispose()
    {
        batch.dispose();
        stage.dispose();
    }

    @Override public void resize(int width, int height)
    {
        camera.configureCamera();
        stage.getViewport().update(width, height, true);
    }

    @Override public void pause()
    {
    }

    @Override public void resume()
    {
    }
}

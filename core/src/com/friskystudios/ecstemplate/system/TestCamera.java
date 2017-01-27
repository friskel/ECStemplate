package com.friskystudios.ecstemplate.system;

import com.artemis.BaseSystem;
import com.artemis.annotations.Wire;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.kotcrab.vis.runtime.system.CameraManager;

/**
 * Created by boppler on 1/27/2017.
 */

@Wire
public class TestCamera extends BaseSystem {
    //this will be automatically assigned by artemis-odb, see @Wire annotation above
    CameraManager cameraManager;

    @Override
    protected void processSystem () {
        Vector3 position = cameraManager.getCamera().position;
        float delta = 0.2f;

        //move camera using WSAD keys

        if(Gdx.input.isKeyPressed(Input.Keys.W))
            position.y += delta;
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            position.y -= delta;

        if(Gdx.input.isKeyPressed(Input.Keys.D))
            position.x += delta;
        else if (Gdx.input.isKeyPressed(Input.Keys.A))
            position.x -= delta;
    }
}

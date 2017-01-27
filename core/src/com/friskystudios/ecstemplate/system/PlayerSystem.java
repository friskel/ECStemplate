package com.friskystudios.ecstemplate.system;

import com.artemis.BaseSystem;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Body;
import com.friskystudios.ecstemplate.component.Velocity;
import com.kotcrab.vis.runtime.component.PhysicsBody;
import com.kotcrab.vis.runtime.component.Transform;
import com.kotcrab.vis.runtime.component.VisSprite;
import com.kotcrab.vis.runtime.system.VisIDManager;
import com.kotcrab.vis.runtime.util.AfterSceneInit;

/**
 * Created by boppler on 1/27/2017.
 */

public class PlayerSystem extends BaseSystem implements AfterSceneInit {
    VisIDManager idManager;
    ComponentMapper<VisSprite> spriteCm;
    ComponentMapper<Transform> transformCm;
    ComponentMapper<Velocity> velocityCm;

    ComponentMapper<PhysicsBody> physicsCm;
    Entity player;
    VisSprite sprite;
    Transform transform;

    Velocity velocity;

    Body body;

    @Override
    public void afterSceneInit() {
        player = idManager.get("guy");
//        player.edit().add(velocity = new Velocity());

        sprite = spriteCm.get(player);
        transform = transformCm.get(player);
        velocity = velocityCm.get(player);


        body = physicsCm.get(player).body;

    }

    @Override
    protected void processSystem() {

        float x = body.getLinearVelocity().x;
        float y = body.getLinearVelocity().y;
        float desiredVel = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            desiredVel = -20;
            sprite.setFlip(true, false);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            desiredVel = 20;
            sprite.setFlip(false, false);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            float impulse = body.getMass() * 200;
            body.applyForce(0, impulse, body.getWorldCenter().x, body.getWorldCenter().y, true);
        }

        float velChange = desiredVel - x;
        float impulse = body.getMass() * velChange;
        body.applyForce(impulse, 0, body.getWorldCenter().x, body.getWorldCenter().y, true);


    }



}

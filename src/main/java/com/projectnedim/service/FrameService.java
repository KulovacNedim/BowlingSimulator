package main.java.com.projectnedim.service;

import main.java.com.projectnedim.model.Frame;

public class FrameService {

    RollService rollService = new RollService();

    public Frame[] getFrames(int skillLevel) {

        Frame[] frames = new Frame[10];

        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame(rollService.getRoll(skillLevel), rollService.getRoll(skillLevel));;
        }

        return frames;
    }
}

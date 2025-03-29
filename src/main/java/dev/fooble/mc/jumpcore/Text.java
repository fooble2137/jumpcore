package dev.fooble.mc.jumpcore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public final class Text {

    private Text() {
    }

    public static Component create(String text) {
        return MiniMessage.miniMessage().deserialize(text);
    }

}
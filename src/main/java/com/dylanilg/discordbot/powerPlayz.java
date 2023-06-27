package com.dylanilg.discordbot;

import com.dylanilg.discordbot.listeners.EventListener;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

/*
  Author: Dylan Ilg
  Product: discord chat bot that manage power playz discord server
  Date:6/10/2023
 */


public class powerPlayz {

    /**
     * Loads our dotenv variables and creates our shard manager
     */
    private final ShardManager shardManager;
    private final Dotenv config;

    /**
     * Bot constructor includes:
     * config object using our dotenv file
     * shardManager builder
     * ShardManager object
     * Status online
     * Access to gateway intents on discord(server members)
     */
    public powerPlayz() {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        shardManager = builder.build();

        // register listeners
        shardManager.addEventListener(new EventListener());

    }
//Getter for config
    public Dotenv getConfig() {

        return config;
    }
//Getter for shardManager
    public ShardManager getShardManager() {

        return shardManager;
    }

    public static void main(String[] args) {
//Creating our bot
        powerPlayz bot = new powerPlayz();

    }
}

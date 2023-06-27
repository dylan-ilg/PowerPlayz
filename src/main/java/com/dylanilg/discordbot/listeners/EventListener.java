package com.dylanilg.discordbot.listeners;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

public class EventListener extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        // Get the guild and the "Members" role
        Role membersRole = event.getGuild().getRolesByName("Members", true).get(0);

        // Add the role to the joined member
        event.getGuild().addRoleToMember(event.getMember(), membersRole).queue();
    }




}

package com.ksk.service;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.auth.AuthTestRequest;
import com.slack.api.methods.request.conversations.ConversationsInfoRequest;
import com.slack.api.methods.response.auth.AuthTestResponse;
import com.slack.api.methods.response.conversations.ConversationsInfoResponse;

import java.io.IOException;

public class SlackValidator {

    private final String slackToken;

    public SlackValidator(String slackToken) {
        this.slackToken = slackToken;
    }

    public boolean isChannelValid(String channelId) {
        try {
            ConversationsInfoResponse response = Slack.getInstance().methods(slackToken)
                    .conversationsInfo(ConversationsInfoRequest.builder().channel(channelId).build());

            return response.isOk();
        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAuthTokenValid() {
        try {
            AuthTestResponse response = Slack.getInstance().methods(slackToken).authTest(AuthTestRequest.builder().build());
            return response.isOk();
        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Replace "YOUR_SLACK_BOT_TOKEN" with your actual Slack Bot Token
        String slackToken = "xoxb-1450465427463-5469859706037-tGM5u7i8KjVyu3ZeUC82VtPm";
        String channelId = "C05JPS3FYUV";

        SlackValidator validator = new SlackValidator(slackToken);

        // Replace "YOUR_SLACK_CHANNEL_ID" with the Channel ID you want to validate


        // Check if the AuthToken is valid
        if (validator.isAuthTokenValid()) {
            System.out.println("AuthToken is valid.");
        } else {
            System.out.println("AuthToken is invalid.");
        }

        // Check if the Channel ID is valid
        if (validator.isChannelValid(channelId)) {
            System.out.println("Channel ID is valid.");
        } else {
            System.out.println("Channel ID is invalid or the token doesn't have access to the channel.");
        }


    }
}


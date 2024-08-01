package myVkBot.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;
import myVkBot.Constants;
import myVkBot.enums.CallbackApi;
import lombok.Getter;
import lombok.Setter;
import myVkBot.model.MessageDTO;
import myVkBot.repository.MessageRepository;


@Getter
@Setter
@RequiredArgsConstructor
public class Event {

    private final MessageRepository messageRepository;

    @JsonProperty(Constants.EVENT_TYPE)
    private CallbackApi type;

    @JsonProperty(Constants.EVENT_GROUP_ID)
    private Long groupId;

    @JsonProperty(Constants.EVENT_ID)
    private String eventId;

    @JsonProperty(Constants.EVENT_SECRET)
    private String secret;

    @JsonValue
    @JsonProperty(Constants.EVENT_OBJECT)
    private EventObject eventObject;

    @Override
    public String toString() {
        String message;

        if (type == CallbackApi.MESSAGE_NEW) {
            message = "type: '" + type.name()
                    + "', text: '" + eventObject.getText()
                    + "', from user_id: " + eventObject.getUserId();
        } else if (type == CallbackApi.MESSAGE_REPLY) {
            message = "type: '" + type.name()
                    + "', text: '" + eventObject.getText()
                    + "', to user_id: " + eventObject.getUserId();
        } else {
            message = "type: '" + type.name();
        }

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setUserId(String.valueOf(eventObject.getUserId()));
        messageDTO.setMessage(eventObject.getText());
        messageRepository.save(messageDTO);
        return message;
    }
}

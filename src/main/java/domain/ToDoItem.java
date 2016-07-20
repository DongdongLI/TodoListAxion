package domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import command.CreateToDoItemCommand;
import command.MarkCompletedCommand;
import event.ToDoItemCompletedEvent;
import event.ToDoItemCreatedEvent;

public class ToDoItem extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public ToDoItem() {
    }

    @CommandHandler
    public ToDoItem(final CreateToDoItemCommand command) {
        apply(new ToDoItemCreatedEvent(command.getTodoId(), command.getDescription()));
    }

    @CommandHandler
    public void markCompleted(final MarkCompletedCommand command) {
        apply(new ToDoItemCompletedEvent(id));
    }

    @EventHandler
    public void on(final ToDoItemCreatedEvent event) {
        this.id = event.getTodoId();
    }
}
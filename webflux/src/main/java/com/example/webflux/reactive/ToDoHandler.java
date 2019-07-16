package com.example.webflux.reactive;

import com.example.webflux.domain.ToDo;
import com.example.webflux.repository.ToDoRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class ToDoHandler {
    private ToDoRepository toDoRepository;

    public ToDoHandler(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Mono<ServerResponse> getToDo(ServerRequest serverRequest) {
        String toDoId = serverRequest.pathVariable("id");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<ToDo> toDo = this.toDoRepository.findById(toDoId);
        return toDo.flatMap(t ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(t)))
                .switchIfEmpty(notFound);


    }

    public Mono<ServerResponse> getToDos(ServerRequest serverRequest){
        Flux<ToDo> toDos=this.toDoRepository.findAll();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(toDos,ToDo.class);
    }
}

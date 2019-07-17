package com.example.rxdata.reactive;

import com.example.rxdata.domain.ToDo;
import com.example.rxdata.repository.ToDoRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class ToDoHandler {

    private ToDoRepository toDoRepository;

    public ToDoHandler(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Mono<ServerResponse> getToDo(ServerRequest serverRequest) {
        return findById(serverRequest.pathVariable("id"));
    }

    public Mono<ServerResponse> getToDos(ServerRequest serverRequest) {
        Flux<ToDo> toDos = this.toDoRepository.findAll();
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(toDos, ToDo.class);
    }

    public Mono<ServerResponse> newToDo(ServerRequest serverRequest){
        Mono<ToDo> toDo=serverRequest.bodyToMono(ToDo.class);
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(toDo.flatMap(this::save),ToDo.class));
    }

    private Mono<ServerResponse> findById(String id) {
        Mono<ToDo> toDo = this.toDoRepository.findById(id);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return toDo
                .flatMap(t -> ServerResponse
                        .ok()
                        .contentType((APPLICATION_JSON))
                        .body(fromObject(t)))
                .switchIfEmpty(notFound);
    }

    private Mono<ToDo> save(ToDo toDo){
        return Mono.fromSupplier(
                () ->{
                    toDoRepository
                            .save(toDo)
                            .subscribe();
                    return toDo;
                });
    }

}

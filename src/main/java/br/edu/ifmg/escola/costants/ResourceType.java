package br.edu.ifmg.escola.costants;

public enum ResourceType {
    LESSON_ONLY("Lição"),
    LESSON_TASK("Tarefa"),
    FORUM("Forum"),
    EXTERNAL_LINK("Link externo");

    private String descripton;

    private ResourceType(String descripton){
        this.descripton = descripton;
    }
}

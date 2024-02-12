package org.example.common

/*
* Annotation
* are means of attaching metadata to code.
* To declare an annotation, put the annotation modifier in front of a class
* Additional attributes of the annotation can be specified by annotating the annotation class with meta-annotations
* * @Target specifies the possible kinds of elements which can be annotated with the annotation (such as classes, functions, properties, and expressions);
*
* * @Retention specifies whethers the annotation is stored in the compiled class files and whether it's visible through reflection at runtime (by default, both are true);
*
* * @Repeatable allows using the same annotation on a single element multiple times;
*
* * @MustBeDocumented specifies that the annotation is part of the public API and should be included in the class or method signature shown in the generated API documentation.
* */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class BindRoute(val path: String) {}

@BindRoute("/auth")
class SimpleHttpController {
    @BindRoute("/signin/")
    fun signIn(@BindRoute("/test") request: Any) {
        print("on-signin route called")
    }
}
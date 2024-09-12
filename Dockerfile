
FROM bellsoft/liberica-openjdk-alpine:11

# Копируем исходный код в контейнер
COPY ./src ./src

# Создаем директории для выходных файлов и документации
RUN mkdir -p ./out ./doc

# Компилируем исходный код и создаем javadoc
RUN javac -sourcepath ./src -d /out ./src/ru/gb/jcore/regular/*.java
    && javadoc -d mydocumentation -sourcepath ./src -cp ./out -subpackages ./src/ru/gb/jcore/regular/

# Запускаем Java приложение и открываем страницу javadoc в браузере
CMD java -classpath ./out roduction/GB_Java_Core/ru/gb/jcore/regular/Main.class/main/Main
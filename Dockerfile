FROM openjdk:8-jre-slim

EXPOSE 8080

ARG clinet_id
ARG client_secret
ENV clinet_id=${clinet_id}
ENV client_secret=${client_secret}

RUN mkdir /app

COPY ./github-actions-dashboard-server/build/libs/*.jar /app/github-actions-dashboard-server.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "--spring.security.oauth2.client.registration.github.client-id=${clinet_id}", "--spring.security.oauth2.client.registration.github.client-secret=${client_secret}", "-jar" ,"/app/github-actions-dashboard-server.jar"]

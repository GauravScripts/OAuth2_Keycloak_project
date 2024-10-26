import Keycloak from "keycloak-js";

const keyclock = new Keycloak({
    url: "http://localhost:8080",
    realm: "yt-dev",
    clientId: "auth-client",
    pkceMethod: "S256",
});

export default keyclock;
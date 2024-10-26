import { createContext, useContext, useEffect, useState } from "react";
import PropTypes from "prop-types";
import { toast } from "react-hot-toast";
import keycloak from "./keyclock.js"; // Correct import path

const Authcontext = createContext();

export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [keyCloakObject, setKeyCloakObject] = useState(null);

    useEffect(() => {
        keycloak.init({
            onLoad: 'login-required',
            pkceMethod: 'S256',
            checkLoginIframe: false // Disable third-party cookie check
        }).then(authenticated => {
            console.log(authenticated);
            setIsAuthenticated(authenticated);
            setKeyCloakObject(keycloak);
            toast.success('Authenticated');
        }).catch((e) => {
            toast.error('Not Authenticated');
            console.error('Keycloak initialization error:', e);
        });
    }, []);

    return (
        <Authcontext.Provider value={{ isAuthenticated }}>
            {children}
        </Authcontext.Provider>
    );
};

AuthProvider.propTypes = {
    children: PropTypes.node.isRequired,
};

export const useAuth = () => useContext(Authcontext);
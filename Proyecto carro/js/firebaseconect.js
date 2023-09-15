
// Ingresar en el head del index.html
<script type="module" src="firebaseconect.js"></script>


import { initializeApp } from "https://www.gstatic.com/firebasejs/9.21.0/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.21.0/firebase-analytics.js";
import { getAuth, createUserWithEmailAndPassword, signInWithEmailAndPassword, signOut } from "https://www.gstatic.com/firebasejs/9.21.0/firebase-auth.js";

const firebaseConfig = {
  apiKey: "AIzaSyANEjZ9WlZYSC4xB83b93pfiYmJ6ptccLs",
  authDomain: "proyecto-carro-1b062.firebaseapp.com",
  databaseURL: "https://proyecto-carro-1b062-default-rtdb.firebaseio.com",
  projectId: "proyecto-carro-1b062",
  storageBucket: "proyecto-carro-1b062.appspot.com",
  messagingSenderId: "47972013115",
  appId: "1:47972013115:web:b136fd718be1e8eede381e",
  measurementId: "G-H8CLCRDLHN"
};

const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const auth = getAuth();

export class ManageAccount {
  register(email, password) {
    createUserWithEmailAndPassword(auth, email, password)
      .then((_) => {
        window.location.href = "login.html";
        // Mostrar alerta de registro exitoso
        alert("Registro exitoso. Serás redirigido a la página de inicio de sesión.");
      })
      .catch((error) => {
        console.error(error.message);
            // Mostrar alerta de error de registro
            alert("Error al registrar: " + error.message);
      });
  }

  authenticate(email, password) {
    signInWithEmailAndPassword(auth, email, password)
      .then((_) => {
        window.location.href = "index.html";
        // Mostrar alerta de inicio de sesión exitoso
        alert("Has iniciado sesión correctamente. Serás redirigido a la página principal.");
      })
      .catch((error) => {
        console.error(error.message);
                // Mostrar alerta de error de inicio de sesión
                alert("Error al iniciar sesión: " + error.message);
      });
  }

  signOut() {
    signOut(auth)
      .then((_) => {
        window.location.href = "index.html";
      })
      .catch((error) => {
        console.error(error.message);
      });
  }
}
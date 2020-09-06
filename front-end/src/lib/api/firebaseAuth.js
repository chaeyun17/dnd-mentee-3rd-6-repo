import * as firebase from 'firebase/app';
import 'firebase/auth';

// Initialize Firebase
firebase.initializeApp({
  apiKey: `${process.env.REACT_APP_FIREBASE_API_KEY}`,
  authDomain: 'neighbor-cats.firebaseapp.com',
  databaseURL: 'https://neighbor-cats.firebaseio.com',
  projectId: 'neighbor-cats',
  storageBucket: 'neighbor-cats.appspot.com',
  messagingSenderId: '884760808488',
  appId: '1:884760808488:web:76e285f32ea768f0fe391d',
  measurementId: 'G-BSZPP7713H',
});

export default firebase;

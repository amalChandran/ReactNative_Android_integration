'use strict';
import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  ToastAndroid,
  TouchableHighlight,
  View,
  TextInput,
  DeviceEventEmitter
} from 'react-native';

import ToastOneAndroid from './reactapp/ToastOneAndroid';
import MessageFromReact from './reactapp/MessageFromReact';
import CallbackUI from './reactapp/CallbackUI';

class HelloWorld extends React.Component {

  constructor(){
    super();
    this.state = {  message: "To Android!" };

    DeviceEventEmitter.addListener('from_android', (e) => {
      this.setState({ message: e.message });
    });
  }

  render() {
    return (
      <View style={styles.container}>
        <TextInput
          style={{height: 40}}
          placeholder="React native to Android!"
          value={this.state.message}
          onChangeText={(text) => MessageFromReact.send(text)}
        />
      </View>
    )
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);
AppRegistry.registerComponent('CallbackUI', () => CallbackUI);
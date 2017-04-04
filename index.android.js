'use strict';
import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  Image,
  ToastAndroid,
  TouchableHighlight,
  View,
  TextInput,
  DeviceEventEmitter
} from 'react-native';

import MessageFromReact from './reactapp/MessageFromReact';
import CallbackUI from './reactapp/CallbackUI';
import NativeModuleUI from './reactapp/NativeUiModuleUI';

class HelloWorld extends React.Component {

  constructor(){
    super();
    this.state = {  message: "To Android! 1" };

    DeviceEventEmitter.addListener('from_android', (e) => {
      this.setState({ message: e.message });
    });

  }

  render() {
    return (
      <View style={styles.container}>
      <Image style={styles.image} resizeMode={Image.resizeMode.contain} source={require("./reactapp/images/header_logo.png")}/>
        <TextInput
          style={styles.hello}
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
    backgroundColor: '#00a4d3',
    alignItems: 'center'
  },
  hello: {
    alignSelf: 'stretch',
    fontSize: 16,
    textAlign: 'center'
  },
  image: {
    width : 45,
    height : 45
  }
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);
AppRegistry.registerComponent('CallbackUI', () => CallbackUI);
AppRegistry.registerComponent('NativeModuleUI', () => NativeModuleUI);
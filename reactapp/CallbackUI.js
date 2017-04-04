import React from 'react';
import { View, Text, StyleSheet, Button, ToastAndroid } from 'react-native';

import Callback from './Callback';

export default class CallbackUI extends React.Component {
  render() {
    return ( 
        <View style={styles.mainContainer}>
          <Text>CallbackUI</Text> 
          <Button
            title = "Pass a callback to Android 6"
            onPress = {()=> { Callback.waitOnAndroidAndCallback(2000, (msg) => {ToastAndroid.show(msg, ToastAndroid.SHORT);} ); }}
            accessibilityLabel="This calls android using native modules and android triggers a callback.">
          </Button>
        </View>
      );
  }
}

var styles = StyleSheet.create({
   mainContainer:{
        flex : 1,
        backgroundColor:'#81c04d',
        flexDirection: 'column',
        justifyContent: 'space-around',
        alignItems: 'center',
    }
});

module.exports = CallbackUI;
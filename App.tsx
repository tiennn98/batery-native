import React from 'react';
import {
  Alert,
  NativeModules,
  Platform,
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
} from 'react-native';

function App(): JSX.Element {
  const onCheckBatteryLevel = () => {
    const {BatteryModule} = NativeModules;
    BatteryModule.getDeviceBatteryLevel()
      .then((batteryLevel: number) => {
        Alert.alert(
          `The battery level is ${
            Platform.OS === 'android' ? batteryLevel * 100 : batteryLevel
          }%`,
        );
      })
      .catch((err: any) => {
        console.error('Failed to get battery level:', err);
      });
  };

  return (
    <SafeAreaView style={styles.container}>
      <TouchableOpacity onPress={onCheckBatteryLevel} style={styles.button}>
        <Text style={styles.text}>Check Battery</Text>
      </TouchableOpacity>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    alignItems: 'center',
    flex: 1,
  },
  button: {
    backgroundColor: 'red',
    borderRadius: 999,
  },
  text: {
    paddingHorizontal: 50,
    paddingVertical: 10,
    color: 'white',
    fontSize: 18,
    fontWeight: 'bold',
  },
});

export default App;

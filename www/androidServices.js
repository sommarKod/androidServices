
/*
 * Service Name
 * This needs to be full qualified name of your service class
 * This will be the combination of the package & class name in your service java file
 */
var serviceName = 'com.androidServices.AndroidServices';

/*
 * Get an instance of the background service factory
 * Use it to create a background service wrapper for your service
 */
var factory = require('com.red_folder.phonegap.plugin.backgroundservice.BackgroundService');
module.exports = factory.create(serviceName);

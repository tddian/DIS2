//
//  AppDelegate.h
//  Assignment6 - Hello Mac OSX
//
//  Created by Giorgio Pretto on 6/16/14.
//  Copyright (c) 2014 Giorgio Pretto. All rights reserved.
//

#import <Cocoa/Cocoa.h>

@interface AppDelegate : NSObject <NSApplicationDelegate>

@property (assign) IBOutlet NSWindow *window;

// core data stuff
@property (readonly, strong, nonatomic) NSPersistentStoreCoordinator *persistentStoreCoordinator;
@property (readonly, strong, nonatomic) NSManagedObjectModel *managedObjectModel;
@property (readonly, strong, nonatomic) NSManagedObjectContext *managedObjectContext;

- (IBAction)saveAction:(id)sender;




// reference to the radio group
@property (weak) IBOutlet NSMatrix *LanguagesRadioGroup;
// reference to the label
@property (weak) IBOutlet NSTextField *GreetingLabel;

//action to be performed when i click on a radio button
- (IBAction)ChangeLanguage:(NSButtonCell *)sender;



@end

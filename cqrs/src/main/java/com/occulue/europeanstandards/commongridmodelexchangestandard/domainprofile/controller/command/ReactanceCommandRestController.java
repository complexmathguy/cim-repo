/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.command;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.controller.command.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller command CQRS processing for entity Reactance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Reactance")
public class ReactanceCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Reactance. if not key provided, calls create, otherwise calls save
   *
   * @param Reactance reactance
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateReactanceCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = ReactanceBusinessDelegate.getReactanceInstance().createReactance(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Reactance. if no key provided, calls create, otherwise calls save
   *
   * @param Reactance reactance
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateReactanceCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateReactanceCommand
      // -----------------------------------------------
      completableFuture = ReactanceBusinessDelegate.getReactanceInstance().updateReactance(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "ReactanceController:update() - successfully update Reactance - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Reactance entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID reactanceId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteReactanceCommand command = new DeleteReactanceCommand(reactanceId);

    try {
      ReactanceBusinessDelegate delegate = ReactanceBusinessDelegate.getReactanceInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Reactance with key " + command.getReactanceId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Value on Reactance
   *
   * @param command AssignValueToReactanceCommand
   */
  @PutMapping("/assignValue")
  public void assignValue(@RequestBody AssignValueToReactanceCommand command) {
    try {
      ReactanceBusinessDelegate.getReactanceInstance().assignValue(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Value", exc);
    }
  }

  /**
   * unassign Value on Reactance
   *
   * @param command UnAssignValueFromReactanceCommand
   */
  @PutMapping("/unAssignValue")
  public void unAssignValue(
      @RequestBody(required = true) UnAssignValueFromReactanceCommand command) {
    try {
      ReactanceBusinessDelegate.getReactanceInstance().unAssignValue(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Value", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Reactance reactance = null;
  private static final Logger LOGGER =
      Logger.getLogger(ReactanceCommandRestController.class.getName());
}

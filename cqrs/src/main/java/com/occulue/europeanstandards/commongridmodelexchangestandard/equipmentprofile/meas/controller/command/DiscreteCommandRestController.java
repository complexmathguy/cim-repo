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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity Discrete.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Discrete")
public class DiscreteCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a Discrete. if not key provided, calls create, otherwise calls save
   *
   * @param Discrete discrete
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateDiscreteCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture = DiscreteBusinessDelegate.getDiscreteInstance().createDiscrete(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a Discrete. if no key provided, calls create, otherwise calls save
   *
   * @param Discrete discrete
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateDiscreteCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateDiscreteCommand
      // -----------------------------------------------
      completableFuture = DiscreteBusinessDelegate.getDiscreteInstance().updateDiscrete(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "DiscreteController:update() - successfully update Discrete - " + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a Discrete entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID discreteId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteDiscreteCommand command = new DeleteDiscreteCommand(discreteId);

    try {
      DiscreteBusinessDelegate delegate = DiscreteBusinessDelegate.getDiscreteInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING, "Successfully deleted Discrete with key " + command.getDiscreteId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Discretes on Discrete
   *
   * @param command AssignDiscretesToDiscreteCommand
   */
  @PutMapping("/addToDiscretes")
  public void addToDiscretes(
      @RequestBody(required = true) AssignDiscretesToDiscreteCommand command) {
    try {
      DiscreteBusinessDelegate.getDiscreteInstance().addToDiscretes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set Discretes", exc);
    }
  }

  /**
   * remove Discretes on Discrete
   *
   * @param command RemoveDiscretesFromDiscreteCommand
   */
  @PutMapping("/removeFromDiscretes")
  public void removeFromDiscretes(
      @RequestBody(required = true) RemoveDiscretesFromDiscreteCommand command) {
    try {
      DiscreteBusinessDelegate.getDiscreteInstance().removeFromDiscretes(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set Discretes", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Discrete discrete = null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscreteCommandRestController.class.getName());
}

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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity OperationalLimitSet.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OperationalLimitSet")
public class OperationalLimitSetCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a OperationalLimitSet. if not key provided, calls create, otherwise calls save
   *
   * @param OperationalLimitSet operationalLimitSet
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateOperationalLimitSetCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance()
              .createOperationalLimitSet(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a OperationalLimitSet. if no key provided, calls create, otherwise calls save
   *
   * @param OperationalLimitSet operationalLimitSet
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateOperationalLimitSetCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateOperationalLimitSetCommand
      // -----------------------------------------------
      completableFuture =
          OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance()
              .updateOperationalLimitSet(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "OperationalLimitSetController:update() - successfully update OperationalLimitSet - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a OperationalLimitSet entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID operationalLimitSetId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteOperationalLimitSetCommand command =
        new DeleteOperationalLimitSetCommand(operationalLimitSetId);

    try {
      OperationalLimitSetBusinessDelegate delegate =
          OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted OperationalLimitSet with key "
              + command.getOperationalLimitSetId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save OperationalLimitSet on OperationalLimitSet
   *
   * @param command AssignOperationalLimitSetToOperationalLimitSetCommand
   */
  @PutMapping("/addToOperationalLimitSet")
  public void addToOperationalLimitSet(
      @RequestBody(required = true) AssignOperationalLimitSetToOperationalLimitSetCommand command) {
    try {
      OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance()
          .addToOperationalLimitSet(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to add to Set OperationalLimitSet", exc);
    }
  }

  /**
   * remove OperationalLimitSet on OperationalLimitSet
   *
   * @param command RemoveOperationalLimitSetFromOperationalLimitSetCommand
   */
  @PutMapping("/removeFromOperationalLimitSet")
  public void removeFromOperationalLimitSet(
      @RequestBody(required = true)
          RemoveOperationalLimitSetFromOperationalLimitSetCommand command) {
    try {
      OperationalLimitSetBusinessDelegate.getOperationalLimitSetInstance()
          .removeFromOperationalLimitSet(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to remove from Set OperationalLimitSet", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OperationalLimitSet operationalLimitSet = null;
  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitSetCommandRestController.class.getName());
}

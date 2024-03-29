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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PhaseTapChanger.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PhaseTapChanger")
public class PhaseTapChangerCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a PhaseTapChanger. if not key provided, calls create, otherwise calls save
   *
   * @param PhaseTapChanger phaseTapChanger
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePhaseTapChangerCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance()
              .createPhaseTapChanger(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PhaseTapChanger. if no key provided, calls create, otherwise calls save
   *
   * @param PhaseTapChanger phaseTapChanger
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePhaseTapChangerCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePhaseTapChangerCommand
      // -----------------------------------------------
      completableFuture =
          PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance()
              .updatePhaseTapChanger(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PhaseTapChangerController:update() - successfully update PhaseTapChanger - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PhaseTapChanger entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID phaseTapChangerId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePhaseTapChangerCommand command = new DeletePhaseTapChangerCommand(phaseTapChangerId);

    try {
      PhaseTapChangerBusinessDelegate delegate =
          PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PhaseTapChanger with key " + command.getPhaseTapChangerId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save PhaseTapChanger on PhaseTapChanger
   *
   * @param command AssignPhaseTapChangerToPhaseTapChangerCommand
   */
  @PutMapping("/assignPhaseTapChanger")
  public void assignPhaseTapChanger(
      @RequestBody AssignPhaseTapChangerToPhaseTapChangerCommand command) {
    try {
      PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().assignPhaseTapChanger(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign PhaseTapChanger", exc);
    }
  }

  /**
   * unassign PhaseTapChanger on PhaseTapChanger
   *
   * @param command UnAssignPhaseTapChangerFromPhaseTapChangerCommand
   */
  @PutMapping("/unAssignPhaseTapChanger")
  public void unAssignPhaseTapChanger(
      @RequestBody(required = true) UnAssignPhaseTapChangerFromPhaseTapChangerCommand command) {
    try {
      PhaseTapChangerBusinessDelegate.getPhaseTapChangerInstance().unAssignPhaseTapChanger(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign PhaseTapChanger", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PhaseTapChanger phaseTapChanger = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerCommandRestController.class.getName());
}

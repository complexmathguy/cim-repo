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
 * Implements Spring Controller command CQRS processing for entity BusbarSection.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/BusbarSection")
public class BusbarSectionCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a BusbarSection. if not key provided, calls create, otherwise calls save
   *
   * @param BusbarSection busbarSection
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateBusbarSectionCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          BusbarSectionBusinessDelegate.getBusbarSectionInstance().createBusbarSection(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a BusbarSection. if no key provided, calls create, otherwise calls save
   *
   * @param BusbarSection busbarSection
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateBusbarSectionCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateBusbarSectionCommand
      // -----------------------------------------------
      completableFuture =
          BusbarSectionBusinessDelegate.getBusbarSectionInstance().updateBusbarSection(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "BusbarSectionController:update() - successfully update BusbarSection - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a BusbarSection entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(@RequestParam(required = true) UUID busbarSectionId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteBusbarSectionCommand command = new DeleteBusbarSectionCommand(busbarSectionId);

    try {
      BusbarSectionBusinessDelegate delegate =
          BusbarSectionBusinessDelegate.getBusbarSectionInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted BusbarSection with key " + command.getBusbarSectionId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save IpMax on BusbarSection
   *
   * @param command AssignIpMaxToBusbarSectionCommand
   */
  @PutMapping("/assignIpMax")
  public void assignIpMax(@RequestBody AssignIpMaxToBusbarSectionCommand command) {
    try {
      BusbarSectionBusinessDelegate.getBusbarSectionInstance().assignIpMax(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign IpMax", exc);
    }
  }

  /**
   * unassign IpMax on BusbarSection
   *
   * @param command UnAssignIpMaxFromBusbarSectionCommand
   */
  @PutMapping("/unAssignIpMax")
  public void unAssignIpMax(
      @RequestBody(required = true) UnAssignIpMaxFromBusbarSectionCommand command) {
    try {
      BusbarSectionBusinessDelegate.getBusbarSectionInstance().unAssignIpMax(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign IpMax", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected BusbarSection busbarSection = null;
  private static final Logger LOGGER =
      Logger.getLogger(BusbarSectionCommandRestController.class.getName());
}
